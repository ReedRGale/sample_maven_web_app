import data.*;
import objects.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

class MockModelSpec extends spock.lang.Specification {
  
  def "user creation works in model w/o database"() {
   
    given:
    def userid
    def resultSet = makeResultSet(
    ["userid", "name"  , "age"    ],
    [  1 , "Fred", 35]
    )    
    def user = new User();
    def mockConnection = Mock(Connection)
    def mockStatement = Mock(Statement)
    
    // Number refers to the number of expected calls to the method
    // If the actual number does not match, the test will fail
    1 * mockConnection.createStatement() >> mockStatement
    1 * mockStatement.execute(_ as String, 1) >> true
    1 * mockConnection.isClosed() >> false
    1 * mockStatement.getGeneratedKeys() >> resultSet
    //1 * resultSet.getInt(3) << 1
    user.setName("Jake Smith")
    user.setAge(42)
    //System.setProperty "DBCONN", "jdbc:postgresql://ec2-54-235-204-221.compute-1.amazonaws.com:5432/d19m0j1erhvr7v?user=wxojhmodfpbmsv&password=80cfef5defecd78ff44e5e2bab48a26b06f930d1f57e097a6be957be98358c53&sslmode=require"
    
    when: "test create of new user"
    //userid = Model.Singleton().newUser(user)
    userid = Model.mockSingleton(mockConnection).newUser(user)

    then: "check new user id"
    userid.toString().length() > 0
    userid.getuserid() > 0
    userid.getuserid().equals(1)
    userid.getName().equals("Jake Smith")
    println "\n\n\n\n\n"
    println userid.toString()
    println userid.getuserid()
    println userid.getName()
    //Model.singleton().deleteUser(userid)  
    
  }
  
  def cleanup() {}
  def cleanupSpec() {}
    
  private ResultSet makeResultSet(List<String> aColumns, List... rows) {
    def result = Mock(ResultSet)
    int currentIndex = -1  
 
    result.next() >> { ++currentIndex < rows.length }
    result./get(String|Short|Date|Timestamp)/(_) >> { String argument ->
    rows[currentIndex][aColumns.indexOf(argument)] } 
    result./get(Int)/(3) >> 1    
    return result
  }    
 
}
