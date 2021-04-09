public class Emp {
    private String id;
    private String name;
    private String tariff;

    public Emp(){
        super();
    }
    public Emp(String id, String name, String city){
        this.id=id;
        this.name=name;
        this.tariff=city;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTariff() {
        return tariff;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public void setId(String id) {
        this.id = id;
    }
}
