package com.tcs.service.service

import com.tcs.service.model.*
import com.tcs.service.repo.ECMRRepo
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.stream.Collectors

@Service
class PrepareJson(private var ecmrRepo: ECMRRepo) {


    fun manipulation(result: MutableList<ASN>?) {
        println(result?.size)

        val posts: MutableList<ASN>? = result
        val ecmrList: MutableList<ECMR> = mutableListOf()

        val postsPerType = posts?.stream()
                ?.collect(Collectors.groupingBy(ASN::departureId,
                        Collectors.groupingBy(ASN::glnshipfrom,
                                Collectors.groupingBy(ASN::glnshipto,
                                        Collectors.groupingBy(ASN::referencenumberoftrip)))))

        if (postsPerType != null) {
            for ((k, v) in postsPerType) {
                for((k1,v1) in v){
                    for((k2,v2) in v1){
                        for((k3,v3) in v2){

                            val ship: MutableList<ASN>? = v3

                            val shipsPerType = ship?.stream()
                                    ?.collect(Collectors.groupingBy(ASN::containertypegtinprimarycontai,
                                            Collectors.groupingBy(ASN::shipunitsscc,
                                                    Collectors.groupingBy(ASN::totalloadweight))))

                            val shipUnit: MutableList<ShipUnit> = mutableListOf()
                            if (shipsPerType != null) {
                                for ((k4,v4) in shipsPerType){
                                    for ((k5,v5) in v4){
                                        for ((k6,v6) in v5){
                                            val containerInShipItems: MutableList<ContainerInShipItems> = mutableListOf()
                                            for (i in 0 until v6.size){
                                                containerInShipItems.add(ContainerInShipItems(v6[i].containertypegtin,
                                                        v6[i].numberofcontainers))
                                            }
                                            shipUnit.add(ShipUnit(v6[0].containertypegtinprimarycontai,
                                                    v6[0].shipunitsscc,
                                                    v6[0].numberofprimarycontainers,
                                                    v6[0].totalloadweight, containerInShipItems))
                                        }
                                    }
                                }
                            }
                            val orderInShipment: MutableList<OrderInShipment> =
                                    mutableListOf(OrderInShipment(v3[0].refnumberpointofdestination, shipUnit))

                            val ecmr =  ECMR(v3[0].departureId+v3[0].glnshipfrom+v3[0].glnshipto,
                                    v3[0].departureId, v3[0].departureId+v3[0].glnshipfrom+v3[0].glnshipto,
                                    LocalDateTime.now().toString(), null, v3[0].glnshipfrom,
                                    v3[0].glnshipto, v3[0].referencenumberoftrip, v3[0].finishedloadingdatetime.substring(0,4),
                                    v3[0].finishedloadingdatetime, null, null, false,
                                    "Not Created", orderInShipment)


                            ecmrList.add(ecmr)
                        }
                    }
                }
            }
        }

        println("ECMR LIST")
        println(ecmrList)

        for(i in 0 until ecmrList.size){
            ecmrRepo.save(ecmrList[i])
        }

    }
}