import com.corejava.common.DirList;
import com.corejava.Employee;
import com.corejava.common.FileStreamTest;
import com.corejava.mongodb.Database;
import com.corejava.mongodb.Collection;
import com.corejava.pair.Pair;
import com.corejava.pair.PairTest;
import org.bson.Document;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("输入字符，按下'q'退出。");
//        do {
//            c = (char)br.read();
//            System.out.println(c);
//        } while (c != 'q');

        // dir
        DirList.listDir();


        System.out.println("Hello World!");

        Employee employee = new Employee("employee");
        employee.setAge(18);
        System.out.println(employee.getId());
        System.out.println(employee.getName());
        System.out.println(employee.getAge());

        Employee newEmployee = new Employee("new employee");
        System.out.println(newEmployee.getId());
        System.out.println(newEmployee.getName());

        FileStreamTest.writeFile();

        // mongodb
        mongodb();

        // test T
        testT();

    }

    /**
     * T
     */
    public static void testT() {
        Double[] number = {
                13.0, 39.0, 6.22, 90.3, 12.5, 22.7, 92.2, 78.0
        };
        Pair<Double> pair = PairTest.minmax(number);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }

    /**
     * mongodb
     */
    public static void mongodb() {

        Database database = new Database("mock");
        System.out.print(database.getDbName());
        System.out.print(database.getCollection("orders"));
        System.out.print(database.listCollectionNames());

        // test_metric
        ArrayList<HashMap> records = operateTestMetric(database);
        System.out.println(records);

        // order
        ArrayList<HashMap> orders = operateOrders(database);
        System.out.println(orders);

    }

    /**
     * mongodb findAll
     * @param database
     * @return
     */
    public static ArrayList<HashMap> operateTestMetric(Database database) {
        Collection collection = database.getCollection("test_metric");
        System.out.print(collection.getCollecionName());

        // 查找所有的记录
        ArrayList<Document> metrics = collection.findAll(0, 10);
        ArrayList<HashMap>records = new ArrayList<>();
        for (Document metric: metrics) {
            HashMap<String, Object> record = new HashMap<>();
            Object id = metric.get("id");
            if (id != null) {
                id = id.toString();
            }
            record.put("id", id);

            String name = metric.get("name").toString();
            record.put("name", name);

            records.add(record);
        }

        return records;
    }

    public static ArrayList<HashMap> operateOrders(Database database) {
        Collection collection = database.getCollection("orders");
        System.out.print(collection.getCollecionName());

        // 查找所有的记录
        ArrayList<Document> metrics = collection.findAll(0, 10);
        ArrayList<HashMap>records = new ArrayList<>();
        System.out.println(metrics);
        for (Document metric: metrics) {
            HashMap<String, Object> record = new HashMap<>();
            Object userId = metric.get("userId");
            record.put("userId", userId);

            String name = metric.get("name").toString();
            record.put("name", name);
            String city = metric.get("city").toString();
            record.put("city", city);
            Object orderLines = metric.get("orderLines");
            record.put("orderLines", orderLines);


            records.add(record);
        }

        return records;
    }
}