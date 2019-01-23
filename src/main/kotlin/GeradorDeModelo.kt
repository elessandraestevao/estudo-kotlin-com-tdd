import com.sun.org.apache.xpath.internal.operations.Bool

class GeradorDeModelo {

    fun criaModelo(nameClass: String, atributes: String): String {
        val segmentsOfAtributes = atributes.split(" ")
        var atributeModel = ""
        if (atributes.isNotEmpty() && atributes.isNotBlank()) {
            for (atribute in segmentsOfAtributes) {
                if (atribute.isNotEmpty() && atribute.isNotBlank()) {
                    if (atributeModel.isEmpty()) {
                        atributeModel = "val $atribute"
                    } else {
                        atributeModel += ", val $atribute"
                    }
                }
            }
        }
        if (nameClass.isEmpty()) {
            return "Class name invalid!"
        }
        var nameClassUpdated = ""
        if (Character.isLowerCase(nameClass.get(0))) {
            nameClassUpdated = nameClass.capitalize()
        }
        if ((isUpperCase(nameClass))){
            val nameClassLowerCase = nameClass.toLowerCase()
            nameClassUpdated = nameClassLowerCase.capitalize()
        }
        return "class $nameClassUpdated($atributeModel)"
    }

    fun isUpperCase(str:String) : Boolean{
        return str === str.toUpperCase();
    }
}