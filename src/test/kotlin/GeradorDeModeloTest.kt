import junit.framework.AssertionFailedError
import org.junit.Assert
import org.junit.Test

class GeradorDeModeloTest {

    @Test
    fun criaModeloComApenasUmAtributo(){
        val geradorDeModelo = GeradorDeModelo()
        val modeloGerado: String = geradorDeModelo.criaModelo("User", "name:String")
        Assert.assertTrue(modeloGerado.equals("class User(val name:String)"))
    }

    @Test
    fun criaModeloComDoisAtributos(){
        val geradorDeModelo = GeradorDeModelo()
        val modeloGerado: String = geradorDeModelo.criaModelo("User", "name:String idade:Int")
        Assert.assertTrue(modeloGerado.equals("class User(val name:String, val idade:Int)"))
    }

    @Test
    fun criaModeloComTresAtributos(){
        val geradorDeModelo = GeradorDeModelo()
        val modeloGerado: String = geradorDeModelo.criaModelo("User", "name:String idade:Int altura:Double")
        Assert.assertTrue(modeloGerado.equals("class User(val name:String, val idade:Int, val altura:Double)"))
    }

    @Test
    fun criaModeloComSeisAtributos(){
        val geradorDeModelo = GeradorDeModelo()
        val modeloGerado: String = geradorDeModelo.criaModelo("User", "name:String idade:Int altura:Double hobby:String pets:Int peso:Double")
        Assert.assertTrue(modeloGerado.equals("class User(val name:String, val idade:Int, val altura:Double, val hobby:String, val pets:Int, val peso:Double)"))
    }

    @Test
    fun criaModeloSemAtributo(){
        val geradorDeModelo = GeradorDeModelo()
        val modeloGerado: String = geradorDeModelo.criaModelo("User", "")
        Assert.assertTrue(modeloGerado.equals("class User()"))
    }

    @Test
    fun erroAoTentarCriarModeloSemNomeDaClasse(){
        val geradorDeModelo = GeradorDeModelo()
        val modeloGerado: String = geradorDeModelo.criaModelo("", "name:String idade:Int")
        Assert.assertTrue(modeloGerado.equals("Class name invalid!"))
    }

    @Test
    fun erroAoTentarCriarModeloSemNomeDaClasseESemAtributos(){
        val geradorDeModelo = GeradorDeModelo()
        val modeloGerado: String = geradorDeModelo.criaModelo("", "")
        Assert.assertTrue(modeloGerado.equals("Class name invalid!"))
    }

    @Test
    fun criaModeloComUmEspacoNoAtributo(){
        val geradorDeModelo = GeradorDeModelo()
        val modeloGerado: String = geradorDeModelo.criaModelo("User", " ")
        Assert.assertTrue(modeloGerado.equals("class User()"))
    }

    @Test
    fun criaModeloComVariosEspacosNoAtributo(){
        val geradorDeModelo = GeradorDeModelo()
        val modeloGerado: String = geradorDeModelo.criaModelo("User", "         ")
        Assert.assertTrue(modeloGerado.equals("class User()"))
    }

    @Test
    fun criaModeloComEspacoNoInicioDoAtributo(){
        val geradorDeModelo = GeradorDeModelo()
        val modeloGerado: String = geradorDeModelo.criaModelo("User", " name:String")
        Assert.assertTrue(modeloGerado.equals("class User(val name:String)"))
    }

    @Test
    fun criaModeloComEspacoNoFimDoAtributo(){
        val geradorDeModelo = GeradorDeModelo()
        val modeloGerado: String = geradorDeModelo.criaModelo("User", "name:String ")
        Assert.assertTrue(modeloGerado.equals("class User(val name:String)"))
    }

    @Test
    fun criaModeloComEspacoNoInicioEFimDoAtributo(){
        val geradorDeModelo = GeradorDeModelo()
        val modeloGerado: String = geradorDeModelo.criaModelo("User", " name:String ")
        Assert.assertTrue(modeloGerado.equals("class User(val name:String)"))
    }

    @Test
    fun criaModeloComVariosEspacosNoInicioEFimDosAtributos(){
        val geradorDeModelo = GeradorDeModelo()
        val modeloGerado: String = geradorDeModelo.criaModelo("User", "      name:String       idade:Int     ")
        Assert.assertTrue(modeloGerado.equals("class User(val name:String, val idade:Int)"))
    }

    @Test
    fun criaModeloTratandoNomeDaClasseEmMinusculo(){
        val geradorDeModelo = GeradorDeModelo()
        val modeloGerado: String = geradorDeModelo.criaModelo("user", "name:String idade:Int")
        Assert.assertTrue(modeloGerado.equals("class User(val name:String, val idade:Int)"))
    }

    @Test
    fun criaModeloTratandoNomeDaClasseTodoMaiusculo(){
        val geradorDeModelo = GeradorDeModelo()
        val modeloGerado: String = geradorDeModelo.criaModelo("USER", "name:String idade:Int")
        Assert.assertTrue(modeloGerado.equals("class User(val name:String, val idade:Int)"))
    }

    //@Test
    fun criaModeloTratandoNomeDaClasseComMaiusculoEMinusculo(){
        val geradorDeModelo = GeradorDeModelo()
        val modeloGerado: String = geradorDeModelo.criaModelo("USeR", "name:String idade:Int")
        println(modeloGerado)
        Assert.assertTrue(modeloGerado.equals("class User(val name:String, val idade:Int)"))
    }
}
