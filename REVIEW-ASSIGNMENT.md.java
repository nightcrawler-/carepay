//Overall, taking advantage of static analysis and code formating would help.
//The creation of unnecesary objects should be avoided
@Component
public class MyAction {
    public boolean debug = true; //This should probably be in a config file or inferred from the environment.
    @Autowired
    public DataSource ds;//It would be better to use a meaningfull name, say dataSource, for this variable. Additionally, the visibility ought to be private.
    //The parameters for this method can be passed in as a POJO with all the fields. That would minimize the chances of a caller passing in the wrong parameters at the right position :)
    public Collection getCustomers(String firstName, String lastName, String address, String zipCode, String city) throws SQLException {
        Connection conn = ds.getConnection(); //This resource should be released at some point.
        String query = new String("SELECT * FROM customers where 1=1");// This is a very bad way to write a query. A prepared statement is better as it reduces the chances of SQL injection.
        //The following 25 lines of code completely fail as the comparisons are all wrong for the kind of data being passed in.
        if (firstName != null) {
            query = query + " and first_name = '" + firstName + "'";
        }
        if (firstName != null) {
            query = query + " and last_name = '" + firstName + "'";
        }
        if (firstName != null) {
            query = query + " and address = '" + address + "'";
        }
        if (firstName != null) {
            query = query + " and zip_code = '" + zipCode + "'";
        }
        if (firstName != null) {
            query = query + " and city = '" + city + "'";
        }
        Statement stmt = conn.createStatement();//Use meaningful names, statement
        ResultSet rs = stmt.executeQuery(query);//Use meanignful names, resultSet
        List customers = new ArrayList();
        while (rs.next()) {
            Object[] objects = new Object[] { rs.getString(1), rs.getString(2) };
            if (debug) print(objects, 4);
            //While reading the ResultSet using column index is more efficient, using the column name would make the code easier to read and understands
            customers.add(new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }
        return customers;
    }

    public void print(Object[] s, int indent) {
        for (int i=0; i<=indent; i++) System.out.print(' ');
        printUpper(s);
    }

    public static void printUpper(Object [] words){
        int i = 0;
        try {
            while (true){//A for loop should suffice for this as the array size can be determined from the length of the array.
                if (words[i].getClass() == String.class) {//Prefer to use instance of instead of class comparisons.
                    String so = (String)words[i];;//This will not compile.
                    so = so.toUpperCase();// Unnecessary re-assignment
                    System.out.println(so);
                }
                i++;
            }
        } catch (IndexOutOfBoundsException e) {//Unnecessary, but it is good practice to catch exceptions. 
            //iteration complete
        }
    }
}