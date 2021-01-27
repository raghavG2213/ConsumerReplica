package com.tcs.service.model

import java.util.*
import javax.persistence.*


data class ASN(
        var departureId:String = "",
        var glnshipfrom:String = "",
        var glnshipto:String = "",
        var referencenumberoftrip:String = "",
        var finishedloadingdatetime: String = "",
        var containertypegtinprimarycontai:String = "",
        var shipunitsscc:String = "",
        var refnumberpointofdestination:String = "",
        var totalloadweight:Int = 0,
        var uomweight:String = "",
        var numberofprimarycontainers:Int = 0,
        var containertypegtin:String = "",
        var numberofcontainers:Int = 0
//    @Id
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
//    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
//    @Column(name = "DEPARTURE_ID")
//    var DEPARTURE_ID:String = "",
//    var GLNSHIPFROM:String = "",
//    var GLNSHIPTO:String = "",
//    var REFERENCENUMBEROFTRIP:String = "",
//    var FINISHEDLOADINGDATETIME:String = "",
//    var CONTAINERTYPEGTINPRIMARYCONTAI:String = "",
//    var SHIPUNITSSCC:String = "",
//    var REFNUMBERPOINTOFDESTINATION:String = "",
//    var TOTALLOADWEIGHT:Int = 0,
//    var UOMWEIGHT:String = "",
//    var NUMBEROFPRIMARYCONTAINERS:Int = 0,
//    var CONTAINERTYPEGTIN:String,
//    var NUMBEROFCONTAINERS:Int
)


