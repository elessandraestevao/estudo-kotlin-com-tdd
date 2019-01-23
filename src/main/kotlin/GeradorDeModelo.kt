class GeradorDeModelo {

    fun criaModelo(nameClass: String, atributes: String): String {
        val segmentsOfAtributes = atributes.split(" ")
        var atributeModel = ""
        if (atributes.isNotEmpty() && atributes.isNotBlank()) {
            for (atribute in segmentsOfAtributes) {
                if (atribute.isNotEmpty()) {
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