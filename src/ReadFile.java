import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import employees.entities.Employee;

public class ReadFile {
  public static void main() {
    List<Employee> list = new ArrayList<>();
    String path = "../in.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String employee = br.readLine();

      while (employee != null) {
        String[]fields = employee.split(",");
        String name = fields[0];
        Double salary = Double.parseDouble(fields[1]);

        list.add(new Employee(name, salary));
        employee = br.readLine();
      }

      // ordenar coleção
      Collections.sort(list);

      for (Employee s : list) {
        System.out.println(s.getName());
      }

    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
