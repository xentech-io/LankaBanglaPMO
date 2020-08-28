package io.xentech.lankabanglapmo.model;

public class DataModel {

    private String dataType;
    private int dataNumber;

    public DataModel(String dataType, int dataNumber) {
        this.dataType = dataType;
        this.dataNumber = dataNumber;
    }


    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getDataNumber() {
        return dataNumber;
    }

    public void setDataNumber(int dataNumber) {
        this.dataNumber = dataNumber;
    }
}
