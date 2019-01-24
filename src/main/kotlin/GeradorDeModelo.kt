import com.sun.org.apache.xpath.internal.operations.Bool

class GeradorDeModelo {

    fun criaModelo(nameClass: String, atributes: String): String {
        if (nameClass.isEmpty()) {
            return "Class name invalid!"
        }
        return "class ${treatNameClass(nameClass)}(${treatAtributes(atributes)})"
    }

    fun treatAtributes(atributes: String): String {
        if (atributes.isNotEmpty() && atributes.isNotBlank()) {
            var atributeModel = ""
            val segmentsOfAtributes = atributes.split(" ")
            for (atribute in segmentsOfAtributes) {
                if (atribute.isNotEmpty() && atribute.isNotBlank()) {
                    if (atributeModel.isEmpty()) {
                        atributeModel = "val $atribute"
                    } else {
                        atributeModel += ", val $atribute"
                    }
                }
            }
            return atributeModel
        } else {
            return ""
        }
    }

    fun treatNameClass(nameClass: String): String {
        if (Character.isLowerCase(nameClass.get(0))) {
            return nameClass.capitalize()
        }
        if ((isUpperCase(nameClass))) {
            val nameClassLowerCase = nameClass.toLowerCase()
            return nameClassLowerCase.capitalize()
        }
        return nameClass
    }

    fun isUpperCase(str: String): Boolean {
        return str === str.toUpperCase();
    }
}