package com.example.employee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class UpdateController {

    @FXML private TextField id, ename, dept, mobNo, salary;
    @FXML private Label lavel;
    @FXML private TableView<Employee> table;
    @FXML private TableColumn<Employee, Integer> eid;
    @FXML private TableColumn<Employee, String> name;
    @FXML private TableColumn<Employee, String> department;
    @FXML private TableColumn<Employee, Double> salary1;
    @FXML private TableColumn<Employee, String> mobile;
    @FXML private Button deleteButton;  // Button to delete selected employee

    private ObservableList<Employee> employeeList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Set up TableView columns
        eid.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getEid()).asObject());
        name.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getName()));
        department.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDepartment()));
        salary1.setCellValueFactory(data -> new javafx.beans.property.SimpleDoubleProperty(data.getValue().getSalary()).asObject());
        mobile.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getMobile()));

        // Initialize the employee list (can be replaced by database data in a real app)
        employeeList.addAll(
                new Employee(124, "", "", "", 0),
                new Employee(224, "", "", "", 0),
                new Employee(324, "", "", "", 0),
                new Employee(424, "", "", "", 0),
                new Employee(524, "", "", "", 0)
        );

        table.setItems(employeeList);

        // Set the TableView selection mode to SINGLE
        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        // Add listener to handle row selection for deletion and updating
        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                id.setText(String.valueOf(newValue.getEid()));
                ename.setText(newValue.getName());
                dept.setText(newValue.getDepartment());
                mobNo.setText(newValue.getMobile());
                salary.setText(String.valueOf(newValue.getSalary()));
            }
        });
    }

    @FXML
    public void updateEmployee() {
        try {
            int empId = Integer.parseInt(id.getText());
            String empName = ename.getText();
            String empDept = dept.getText();
            String empMobile = mobNo.getText();
            double empSalary = Double.parseDouble(salary.getText());

            boolean updated = false;
            for (Employee emp : employeeList) {
                if (emp.getEid() == empId) {
                    emp.setName(empName);
                    emp.setDepartment(empDept);
                    emp.setMobile(empMobile);
                    emp.setSalary(empSalary);
                    table.refresh();
                    lavel.setText("Employee updated successfully!");
                    updated = true;
                    break;
                }
            }

            if (!updated) {
                lavel.setText("Employee ID not found.");
            }

        } catch (NumberFormatException e) {
            lavel.setText("Invalid input. Check ID and Salary.");
        } catch (Exception e) {
            lavel.setText("Error updating employee.");
            e.printStackTrace();
        }
    }

    @FXML
    public void deleteEmployee() {
        // Get the selected employee
        Employee selectedEmployee = table.getSelectionModel().getSelectedItem();

        if (selectedEmployee != null) {
            // Remove the selected employee from the list
            employeeList.remove(selectedEmployee);
            lavel.setText("Employee deleted successfully!");
        } else {
            lavel.setText("No employee selected.");
        }
    }
}
