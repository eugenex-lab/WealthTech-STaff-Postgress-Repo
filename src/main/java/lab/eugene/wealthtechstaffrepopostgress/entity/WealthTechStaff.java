package lab.eugene.wealthtechstaffrepopostgress.entity;

import javax.persistence.*;

@Entity
public class WealthTechStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "staff_name")
    private String staffName;
    @Column(name = "staff_role")
    private String staffRole;
    @Column(name = "service_lenght")
    private Integer lenghtOfServiceYears;

    public WealthTechStaff() {
        super();
    }

    public WealthTechStaff(Integer id, String staffName, String staffRole,
                           Integer lenghtOfServiceYears) {
        this.id = id;
        this.staffName = staffName;
        this.staffRole = staffRole;
        this.lenghtOfServiceYears = lenghtOfServiceYears;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffRole() {
        return staffRole;
    }

    public void setStaffRole(String staffRole) {
        this.staffRole = staffRole;
    }

    public Integer getLenghtOfServiceYears() {
        return lenghtOfServiceYears;
    }

    public void setLenghtOfServiceYears(Integer lenghtOfServiceYears) {
        this.lenghtOfServiceYears = lenghtOfServiceYears;
    }

}
