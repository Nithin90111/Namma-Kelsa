package com.nammakelsa.data.model;

/**
 * Sealed class representing the outcome of a form validation pass.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/nammakelsa/data/model/ValidationResult;", "", "()V", "Invalid", "Valid", "Lcom/nammakelsa/data/model/ValidationResult$Invalid;", "Lcom/nammakelsa/data/model/ValidationResult$Valid;", "app_debug"})
public abstract class ValidationResult {
    
    private ValidationResult() {
        super();
    }
    
    /**
     * One or more fields failed validation.
     *
     * @param errors Non-empty list of field-level errors.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/nammakelsa/data/model/ValidationResult$Invalid;", "Lcom/nammakelsa/data/model/ValidationResult;", "errors", "", "Lcom/nammakelsa/data/model/FieldError;", "(Ljava/util/List;)V", "getErrors", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class Invalid extends com.nammakelsa.data.model.ValidationResult {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.nammakelsa.data.model.FieldError> errors = null;
        
        public Invalid(@org.jetbrains.annotations.NotNull()
        java.util.List<com.nammakelsa.data.model.FieldError> errors) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.nammakelsa.data.model.FieldError> getErrors() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.nammakelsa.data.model.FieldError> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.nammakelsa.data.model.ValidationResult.Invalid copy(@org.jetbrains.annotations.NotNull()
        java.util.List<com.nammakelsa.data.model.FieldError> errors) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    /**
     * All fields passed validation.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/nammakelsa/data/model/ValidationResult$Valid;", "Lcom/nammakelsa/data/model/ValidationResult;", "()V", "app_debug"})
    public static final class Valid extends com.nammakelsa.data.model.ValidationResult {
        @org.jetbrains.annotations.NotNull()
        public static final com.nammakelsa.data.model.ValidationResult.Valid INSTANCE = null;
        
        private Valid() {
        }
    }
}