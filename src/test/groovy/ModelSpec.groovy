
import data.*;
import objects.*;
import spock.lang.IgnoreIf

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


class ModelSpec extends spock.lang.Specification {
    
    def setupSpec() 
    {
        // Can provide hard coded path to DB here
        // be wary of checking into git
        //System.setProperty "DBCONN", "jdbc:postgresql://"
        print"setting default DBConnURL!!!!!!"
        Model.singleton().setDBConnURL("jdbc:postgresql://")
    }
    
    @IgnoreIf({Model.singleton().getDBConnURL() == null})
    def "user persisted to database if connection available"() 
    {
      print"in user persisted to db if conn available test!!!!!!"
      given:
      def usr = new User();
      def userid = 0
      usr.setName("Jake Smith")
      usr.setAge(42)
    
      when: "test create of new user"
      Model.singleton().getDBConnURL() != null
      userid = Model.singleton().newUser(usr)

      then: "check new user id"
      userid.toString().length() > 0
      userid.getuserid() > 0
      userid.getName().equals("Jake Smith")
      
      notThrown(SQLException)
      Model.singleton().deleteUser(userid)  
  }
  
}

