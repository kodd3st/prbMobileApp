package com.example.myapplication;

public class Task {
    private String taskId;
    private String batchId;
    private String stage;
    private String status;
    private String priority;
    private String equipment;
    private String instructions;

    public Task(String taskId, String batchId, String stage, String status, String priority, String equipment, String instructions) {
        this.taskId = taskId;
        this.batchId = batchId;
        this.stage = stage;
        this.status = status;
        this.priority = priority;
        this.equipment = equipment;
        this.instructions = instructions;
    }
    public String getTaskId() {
        return taskId;
    }

    public String getBatchId() {
        return batchId;
    }

    public String getStage() {
        return stage;
    }

    public String getStatus() {
        return status;
    }

    public String getPriority() {
        return priority;
    }

    public String getEquipment() {
        return equipment;
    }

    public String getInstructions() {
        return instructions;
    }
}
