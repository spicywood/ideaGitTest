package Num1_dataStructure.Num8_table.num1_hash;

public class Employee {
    public int id;
    public String name;
    public Employee next;       //默认为空

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
