package ipca.example.temperaturas


class Temperature {

    var uid: String
    var local: String? =  null
    var date : Long? =  null
    var temperature : Double? =  null

    constructor(uid: String, local: String?, date: Long?, temperature: Double?) {
        this.uid = uid
        this.local = local
        this.date = date
        this.temperature = temperature
    }
}

