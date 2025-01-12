import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


import java.util.ArrayList;

public class crudCon {

    @FXML 
    private TableView<ProductTask> AllTable;
    @FXML
    private TableColumn<ProductTask, String> nameCol, brandCol, categoriCol;
    @FXML
    private TableColumn<ProductTask, Integer> priceCol;
    @FXML
    private TableColumn<ProductTask, Integer> stokCol;
    @FXML
    private TextField namaProdField, brandProdField, kategoriField, hargaField, jumlahField;
    @FXML
    private ObservableList<ProductTask> taskList;

    public void initialize() {
        taskList = FXCollections.observableArrayList(TaskFileManager.loadTasks());
        AllTable.setItems(taskList);

        nameCol.setCellValueFactory(new PropertyValueFactory<>("namaProd"));
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brandProd"));
        categoriCol.setCellValueFactory(new PropertyValueFactory<>("kategoriProd"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        stokCol.setCellValueFactory(new PropertyValueFactory<>("stok"));
    }

    public void saveTask() {
        try {
            if (namaProdField.getText().isEmpty() || brandProdField.getText().isEmpty() || 
                kategoriField.getText().isEmpty() || hargaField.getText().isEmpty() || 
                jumlahField.getText().isEmpty()) {
                throw new MissingFieldException("Data anda kosong, harap masukkan data anda !");
            }

            ProductTask task = new ProductTask(
                namaProdField.getText(), 
                brandProdField.getText(), 
                kategoriField.getText(), 
                Integer.parseInt(hargaField.getText()), 
                Integer.parseInt(jumlahField.getText()));
            
            taskList.add(task);
            TaskFileManager.saveTasks(new ArrayList<>(taskList));

        } catch (MissingFieldException e) {
            showError(e.getMessage());
        } catch (NumberFormatException e) {
            showError("Harga dan jumlah harus berupa angka.");
        }
    }
    @FXML
    private void clearData(){
        clearData();
        namaProdField.clear();
        brandProdField.clear();
        kategoriField.clear();
        hargaField.clear();
        jumlahField.clear();
    }
    @FXML
    private void deleteData(){
        try {
            ProductTask selected = AllTable.getSelectionModel().getSelectedItem();
            if (selected == null) {
                throw new TaskNotSelectedException("Tolong pilih data yang akan di hapus");
            }
            taskList.remove(selected);
            TaskFileManager.saveTasks(new ArrayList<>());
        } catch (TaskNotSelectedException e) {
            showError(e.getMessage());
        }

    }
    
    @FXML
    private void updateData(){
        try {
            ProductTask selected = AllTable.getSelectionModel().getSelectedItem();
            if (selected == null) {
                throw new TaskNotSelectedException("Mohon pilih data yang ingin anda rubah!");
            }
            if(namaProdField.getText().isEmpty()  || brandProdField.getText().isEmpty()
            || kategoriField.getText().isEmpty() || hargaField.getText().isEmpty() || jumlahField.getText().isEmpty()){
                throw new MissingFieldException("Data anda kosong tolong masukkan data anda terlebih dahulu!");
            }
            selected.setNamaProd(namaProdField.getText());
            selected.setBrandProd(brandProdField.getText());
            selected.setKategoriProd(brandProdField.getText());
            selected.setPrice(Integer.parseInt(hargaField.getText()));
            selected.setStok(Integer.parseInt(jumlahField.getText()));

            TaskFileManager.saveTasks(new ArrayList<>(taskList));
            AllTable.refresh();
        } catch (MissingFieldException e){
            showError(e.getMessage());
        } catch (NumberFormatException e){
            showError("Harga dan jumlah harus berupa angka.");
        } catch (TaskNotSelectedException e){
            showError(e.getMessage());
        }
    }

    @FXML
    private void logOut(){
        Stage stage = (Stage) AllTable.getScene().getWindow();
        stage.close();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("loginForm.fxml"));
            Parent root = loader.load();    
            Stage loginStage = new Stage();
            loginStage.setTitle("Login Form");
            loginStage.setScene(new Scene(root));
            loginStage.show();
        } catch (IOException e) {
            showError("Gagal untuk logOut dari aplikasi !");
        }
    }
    

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.showAndWait();
    }

}
class MissingFieldException extends Exception {
    public MissingFieldException (String message) {
        super(message);}
}
class TaskNotSelectedException extends Exception {
    public TaskNotSelectedException (String message){
        super(message);
    }
    
}

