package py.com.progweb.primerParcial.models.dto;

public class ErrorDTO {
    private String error;

    public ErrorDTO(String e) {
        this.error = e;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
