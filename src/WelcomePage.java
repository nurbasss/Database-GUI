
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.sql.CallableStatement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class WelcomePage {

    public JFrame frame;
    private JTextField employeeID;
    private JTextField shopID;
    private JTextField firstName;
    private JTextField surname;
    private JTable table;
    private JSpinner age;
    private JTextField birthDate;
    private JTextField salary;
    private JTextField job;
    private JTextField phone;
    private JTextField email;
    private JTextField city;
    private JTextField country;
    String connectionUrl = "jdbc:sqlserver://localhost;database=WearShop;user=user123;password=password111";
    private Connection conn ;
    private PreparedStatement stmt;
    private ResultSet rs;


    public WelcomePage() {
        init();
        try {
            conn = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            System.out.println("db connection problems");
        }
        createTable();
        this.frame.setResizable(true);
    }

    public void createTable() {
        Vector tableColumn = new Vector();
        tableColumn.addElement("Employee ID");
        tableColumn.addElement("First Name");
        tableColumn.addElement("Surname");
        tableColumn.addElement("Job");
        tableColumn.addElement("Salary");
        tableColumn.addElement("Shop ID");
        tableColumn.addElement("age");
        tableColumn.addElement("birth date");
        tableColumn.addElement("phone");
        tableColumn.addElement("email");
        tableColumn.addElement("city");
        tableColumn.addElement("country");


        Vector tableData = new Vector();
        String sql = "SELECT * FROM Employee";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Vector employee = new Vector();
                employee.addElement(rs.getString("employee_id"));
                employee.addElement(rs.getString("first_name"));
                employee.addElement(rs.getString("surname"));
                employee.addElement(rs.getString("job_name"));
                employee.addElement(rs.getString("salary"));
                employee.addElement(rs.getString("shop_id"));
                employee.addElement(rs.getString("age"));
                employee.addElement(rs.getString("birth_date"));
                employee.addElement(rs.getString("phone_number"));
                employee.addElement(rs.getString("email"));
                employee.addElement(rs.getString("city"));
                employee.addElement(rs.getString("country"));

                tableData.add(employee);
            }
        } catch (Exception e) {
            System.out.println("table creation problems");
        }
        table.setModel(new DefaultTableModel(tableData, tableColumn));

    }


    private void init() {

        frame = new JFrame();
        frame.setBounds(100, 100, 1250, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        JLabel lblId = new JLabel("Employee ID:");
        lblId.setBounds(30, 55, 90, 15);
        frame.getContentPane().add(lblId);

        employeeID = new JTextField();
        employeeID.setBounds(120, 55, 50, 20);
        frame.getContentPane().add(employeeID);
        employeeID.setColumns(10);

        JLabel lblRoles = new JLabel("Shop ID:");
        lblRoles.setBounds(30, 85, 60, 15);
        frame.getContentPane().add(lblRoles);

        shopID = new JTextField();
        shopID.setBounds(120, 85, 50, 20);
        frame.getContentPane().add(shopID);
        shopID.setColumns(10);

        JLabel lblFirtsName = new JLabel("First Name:");
        lblFirtsName.setBounds(30, 115, 90, 15);
        frame.getContentPane().add(lblFirtsName);

        firstName = new JTextField();
        firstName.setBounds(120, 115, 90, 20);
        frame.getContentPane().add(firstName);
        firstName.setColumns(10);

        JLabel lblSurname = new JLabel("Surname:");
        lblSurname.setBounds(30, 145, 90, 14);
        frame.getContentPane().add(lblSurname);

        surname = new JTextField();
        surname.setBounds(120, 145, 90, 20);
        frame.getContentPane().add(surname);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setBounds(30, 175, 90, 15);
        frame.getContentPane().add(lblAge);

        age = new JSpinner();
        age.setBounds(120, 175, 50, 20);
        frame.getContentPane().add(age);

        JLabel lblBirth = new JLabel("Birth Date:");
        lblBirth.setBounds(30, 205, 90, 15);
        frame.getContentPane().add(lblBirth);

        birthDate = new JTextField();
        birthDate.setBounds(120, 205, 90, 20);
        frame.getContentPane().add(birthDate);
        birthDate.setColumns(10);

        JLabel lblSalary = new JLabel("Salary:");
        lblSalary.setBounds(30, 235, 90, 15);
        frame.getContentPane().add(lblSalary);

        salary = new JTextField();
        salary.setBounds(120, 235, 90, 20);
        frame.getContentPane().add(salary);
        salary.setColumns(10);

        JLabel lblJob = new JLabel("Job:");
        lblJob.setBounds(30, 265, 90, 15);
        frame.getContentPane().add(lblJob);

        job = new JTextField();
        job.setBounds(120, 265, 90, 20);
        frame.getContentPane().add(job);
        job.setColumns(10);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(30, 295, 90, 15);
        frame.getContentPane().add(lblPhone);

        phone = new JTextField();
        phone.setBounds(120, 295, 90, 20);
        frame.getContentPane().add(phone);
        phone.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 325, 90, 15);
        frame.getContentPane().add(lblEmail);

        email = new JTextField();
        email.setBounds(120, 325, 90, 20);
        frame.getContentPane().add(email);
        email.setColumns(10);

        JLabel lblCity = new JLabel("City:");
        lblCity.setBounds(30, 355, 90, 15);
        frame.getContentPane().add(lblCity);

        city = new JTextField();
        city.setBounds(120, 355, 90, 20);
        frame.getContentPane().add(city);
        city.setColumns(10);

        JLabel lblCountry = new JLabel("Country:");
        lblCountry.setBounds(30, 385, 90, 15);
        frame.getContentPane().add(lblCountry);

        country = new JTextField();
        country.setBounds(120, 385, 90, 20);
        frame.getContentPane().add(country);
        country.setColumns(10);

        JLabel lblSection = new JLabel("Employee Section");
        lblSection.setBounds(10, 20, 200, 20);
        frame.getContentPane().add(lblSection);
        lblSection.setFont(new Font((String)null, 0, 20));


        JLabel lblCompany = new JLabel("Online Wear Store");
        lblCompany.setBounds(550, 355, 500, 60);
        frame.getContentPane().add(lblCompany);
        lblCompany.setFont(new Font((String)null, 0, 50));



        JButton insertButton = new JButton("Insert");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try{
                    String SQL = "{call employee_procedures(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
                    CallableStatement cs = conn.prepareCall(SQL);
                    cs.setString(1, "INSERT");
                    cs.setString(2,employeeID.getText() );
                    cs.setString(3,shopID.getText() );
                    cs.setString(4,firstName.getText() );
                    cs.setString(5,"null" );
                    cs.setString(6,surname.getText() );
                    cs.setInt(7,(Integer)age.getValue());
                    cs.setString(8,birthDate.getText() );
                    cs.setString(9,"2020-12-06");
                    cs.setInt(10, Integer.parseInt(salary.getText()));
                    cs.setString(11,phone.getText());
                    cs.setString(12,email.getText());
                    cs.setString(13,city.getText());
                    cs.setString(14,country.getText());


                    ResultSet rs = cs.executeQuery();
                    rs.close();
                }catch(Exception exc){
                    System.out.println("insert problem");                }
                createTable();
            }
        });
        insertButton.setBounds(230, 160, 110, 25);
        frame.getContentPane().add(insertButton);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String SQL = "{call employee_procedures4(?,?)}";
                    CallableStatement cs = conn.prepareCall(SQL);

                    cs.setInt(1, Integer.parseInt(employeeID.getText()));
                    cs.setInt(2, Integer.parseInt(salary.getText()));

                    ResultSet rs = cs.executeQuery();
                    rs.close();
                }catch(Exception exc){
                    System.out.println("update Problems");
                }
                createTable();
            }
        });
        updateButton.setBounds(230, 250, 110, 25);
        frame.getContentPane().add(updateButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String SQL = "{call employee_procedures(?,?)}";
                    CallableStatement cs = conn.prepareCall(SQL);
                    cs.setString(1, "DELETE");
                    cs.setString(2,employeeID.getText() );

                    ResultSet rs = cs.executeQuery();
                    rs.close();
                }catch(Exception exc){
                    System.out.println("delete problems");
                }
                createTable();
            }

        });
        deleteButton.setBounds(230, 340, 110, 25);
        frame.getContentPane().add(deleteButton);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                employeeID.setText("");
                shopID.setText("");
                firstName.setText("");
                surname.setText("");
                salary.setText("");
                birthDate.setText("");
                age.setValue(0);
                job.setText("");
                phone.setText("");
                email.setText("");
                city.setText("");
                country.setText("");
            }

        });
        resetButton.setBounds(230, 400, 110, 25);
        frame.getContentPane().add(resetButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(400, 55, 800, 200);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row>=0) {
                    employeeID.setText(table.getValueAt(row, 0).toString());
                }
            }
        });
        scrollPane.setViewportView(table);
    }
}