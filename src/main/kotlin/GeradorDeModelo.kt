class GeradorDeModelo {

    fun criaModelo(nameClass: String, atributes: String): String {
        val segmentsOfAtributes = atributes.split(" ")
        var atributeModel = ""
        if (!atributes.isEmpty() && atributes != " ") {
            for (atribute in segmentsOfAtributes) {
                if (atribute != "") {
                    if (atributeModel.isEmpty()) {
                        atributeModel = "val $atribute"
                    } else {
                        atributeModel += ", val $atribute"
                    }
                }
            }
        }
        if (nameClass.isEmpty()) {
            return "class ClassName($atributeModel)"
        }
        return "class $nameClass($atributeModel)"
    }
}