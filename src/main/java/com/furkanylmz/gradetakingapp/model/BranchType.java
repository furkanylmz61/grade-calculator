package com.furkanylmz.gradetakingapp.model;


import io.swagger.v3.oas.annotations.media.Schema;

public enum BranchType {
    @Schema(description = "Math branch")
    MATH("MATH", "Mathematics"),
    PHYSICS("PHYSICS", "Physics"),
    CHEMISTRY("CHEMISTRY", "Chemistry"),
    BIOLOGY("BIOLOGY", "Biology"),
    HISTORY("HISTORY", "History"),
    GEOGRAPHY("GEOGRAPHY", "Geography"),
    LITERATURE("LITERATURE", "Literature"),
    OTHER("OTHER", "Other");

    private final String value;
    private final String displayValue;

    BranchType(String value, String displayValue) {
        this.value = value;
        this.displayValue = displayValue;
    }

    public String getValue() {
        return value;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}