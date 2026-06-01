package Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Hotel_Report extends JFrame implements ActionListener {

    JTable table;
    JLabel titleLabel;
    JButton employeeBtn, bookingBtn, attendanceBtn, billingBtn, back;

    public Hotel_Report() {

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(220, 240, 250));
        p.setBounds(5, 5, 1200, 700);
        add(p);

        JLabel mainTitle = new JLabel("Hotel Management Report");
        mainTitle.setBounds(350, 5, 500, 40);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 32));
        p.add(mainTitle);

        titleLabel = new JLabel("Employee Report");
        titleLabel.setBounds(500, 60, 300, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        p.add(titleLabel);

        back = new JButton("Back");
        back.setBounds(1050, 5, 100, 25);
        p.add(back);
        back.addActionListener(this);

        // Table
        table = new JTable();
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 100, 1180, 500);
        p.add(sp);

        // Buttons
        employeeBtn = new JButton("Employee Report");
        employeeBtn.setBounds(150, 620, 170, 35);
        p.add(employeeBtn);

        bookingBtn = new JButton("Room Booking");
        bookingBtn.setBounds(350, 620, 170, 35);
        p.add(bookingBtn);

        attendanceBtn = new JButton("Staff Attendance");
        attendanceBtn.setBounds(550, 620, 180, 35);
        p.add(attendanceBtn);

        billingBtn = new JButton("Peak Days");
        billingBtn.setBounds(750, 620, 170, 35);
        p.add(billingBtn);

        // Actions
        employeeBtn.addActionListener(e -> {
            loadEmployeeData();
            titleLabel.setText("Employee Report");
        });

        bookingBtn.addActionListener(e -> {
            loadBookingData();
            titleLabel.setText("Room Booking Report");
        });

        attendanceBtn.addActionListener(e -> {
            loadAttendanceData();
            titleLabel.setText("Staff Attendance");
        });

        billingBtn.addActionListener(e -> {
        	loadPeakDaysData();
            titleLabel.setText("Peak Day");
        });
        
        
        // Print Button (same as your example)
           JButton print = new JButton("Print");
           print.setBounds(950, 620, 90, 30);
           print.setForeground(Color.white);
           print.setBackground(Color.black);
           print.setFocusPainted(false);
           print.setFont(new Font("Arial", Font.BOLD, 13));

           print.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   try {
                       table.print();   // printing JTable
                   } catch (Exception v) {
                       v.printStackTrace();
                   }
               }
           });

           p.add(print);

        // Default view
        loadEmployeeData();

        setSize(1200, 700);
        setLayout(null);
        setLocation(200, 80);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
        }
    }

    // ---------------- EMPLOYEE ----------------
    private void loadEmployeeData() {
        String[] cols = {"ID", "Name", "Role", "Salary"};

        Object[][] data = {
            {1,"Raj","Manager","50000"},
            {2,"Amit","Receptionist","25000"},
            {3,"Neha","Housekeeping","18000"},
            {4,"Kiran","Chef","30000"},
            {5,"Sneha","Cleaner","15000"},
            {6,"Ravi","Waiter","16000"},
            {7,"Pooja","Receptionist","24000"},
            {8,"Anil","Security","20000"},
            {9,"Meena","Housekeeping","17000"},
            {10,"Vikas","Chef","32000"},
            {11,"Suresh","Waiter","15500"},
            {12,"Nina","Cleaner","14000"},
            {13,"Arjun","Manager","52000"},
            {14,"Kavita","Receptionist","26000"},
            {15,"Deepak","Security","21000"},
            {16,"Rohit","Chef","31000"},
            {17,"Simran","Housekeeping","18500"},
            {18,"Ajay","Waiter","16500"},
            {19,"Komal","Cleaner","14500"},
            {20,"Varun","Security","22000"},
            {21,"Tina","Receptionist","25500"},
            {22,"Mohit","Chef","33000"},
            {23,"Anita","Housekeeping","17500"},
            {24,"Yash","Waiter","16000"},
            {25,"Rina","Cleaner","15000"},
            {26,"Kunal","Security","20500"},
            {27,"Preeti","Receptionist","24500"},
            {28,"Gaurav","Chef","34000"},
            {29,"Seema","Housekeeping","19000"},
            {30,"Nikhil","Waiter","17000"},
            {31,"Ramesh","Cleaner","15000"},
            {32,"Isha","Receptionist","25000"},
            {33,"Manoj","Security","21000"},
            {34,"Asha","Housekeeping","18000"},
            {35,"Tarun","Chef","35000"},
            {36,"Pankaj","Waiter","17500"},
            {37,"Divya","Cleaner","15500"},
            {38,"Rahul","Security","22000"},
            {39,"Sonal","Receptionist","26000"},
            {40,"Kishan","Chef","36000"},
            {41,"Bhavna","Housekeeping","18500"},
            {42,"Aakash","Waiter","16500"},
            {43,"Rekha","Cleaner","15000"},
            {44,"Harsh","Security","23000"},
            {45,"Mansi","Receptionist","25500"},
            {46,"Chirag","Chef","37000"},
            {47,"Jyoti","Housekeeping","19000"},
            {48,"Sanjay","Waiter","17000"},
            {49,"Payal","Cleaner","15500"},
            {50,"Vivek","Security","24000"},
            {51,"Alok","Chef","38000"},
            {52,"Ritu","Receptionist","26500"}
        };

        table.setModel(new DefaultTableModel(data, cols));
    }

    // ---------------- BOOKING ----------------
    private void loadBookingData() {

        String[] cols = {"Month", "Total Bookings"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        String[] months = {"Jan", "Feb", "Mar", "Apr"};
        int[] daysInMonth = {31, 28, 31, 30};

        int baseGuests = 5;

        for (int m = 0; m < months.length; m++) {

            int totalBookings = 0;

            for (int d = 1; d <= daysInMonth[m]; d++) {

                boolean isWeekend = (d % 7 == 6 || d % 7 == 0);
                boolean isHoliday = (d == 1 || d == 14 || d == 26);

                int guests = baseGuests + (m * 10) + (d % 10);

                if (isWeekend || isHoliday) {
                    guests += 10;
                }

                totalBookings += guests;
            }

            model.addRow(new Object[]{months[m], totalBookings});
        }

        table.setModel(model);
    }

    // ---------------- ATTENDANCE ----------------
    private void loadAttendanceData() {
        String[] cols = {"Month", "Staff", "Present%", "Absent%"};

        Object[][] data = {
                {"Jan", 20, "90%", "10%"},
                {"Feb", 22, "88%", "12%"},
                {"Mar", 25, "92%", "8%"},
        };

        table.setModel(new DefaultTableModel(data, cols));
    }

    // ---------------- BILLING ----------------
    private void loadPeakDaysData() {

        String[] cols = {"Date", "No. of Guests"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        String[] months = {"Jan", "Feb", "Mar", "Apr"};
        int[] daysInMonth = {31, 28, 31, 30};

        int baseGuests = 5;

        for (int m = 0; m < months.length; m++) {
            for (int d = 1; d <= daysInMonth[m]; d++) {

                String date = (d < 10 ? "0" + d : d) + "-" + months[m] + "-2026";

                // Simulate weekend (every 6th & 7th day)
                boolean isWeekend = (d % 7 == 6 || d % 7 == 0);

                // Simulate some special holidays
                boolean isHoliday = (d == 1 || d == 14 || d == 26);

                int guests = baseGuests + (m * 10) + (d % 10);

                // Only add PEAK days
                if (isWeekend || isHoliday) {

                    // Increase guests for peak days
                    guests += 10;

                    model.addRow(new Object[]{date, guests});
                }
            }
        }

        table.setModel(model);
    }
    
 

    public static void main(String[] args) {
        new Hotel_Report();
    }
}