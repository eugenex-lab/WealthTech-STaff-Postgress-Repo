package lab.eugene.wealthtechstaffrepopostgress.WealthTechController;

import lab.eugene.wealthtechstaffrepopostgress.entity.WealthTechStaff;
import lab.eugene.wealthtechstaffrepopostgress.repository.WealthTechStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class WealthTechController {

    @Autowired
    private WealthTechStaffRepository wealthTechStaffRepository;

    // GET WEALTH TECH STAFF

    @GetMapping("home")
    public List<WealthTechStaff> getallStaff() {
        return this.wealthTechStaffRepository.findAll();
    }

    /// Get by STAFF BY ID


    //Save Sankore Product
    @PostMapping("home")
    public WealthTechStaff createStaff(@RequestBody WealthTechStaff wealthTechStaff) {
        checkIfValueExists(wealthTechStaff.getStaffName());
        return this.wealthTechStaffRepository.save(wealthTechStaff);
    }

    @GetMapping("/home/{id}")
    public ResponseEntity<WealthTechStaff> GetStaffById(@PathVariable("id") Integer staffId) {
        WealthTechStaff wealthTechStaff = wealthTechStaffRepository.findById(staffId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student id : " + staffId));
        return ResponseEntity.ok().body(wealthTechStaff);
    }

    /// UPATE STAFF RECORD
    @PutMapping("/home/{id}")
    public ResponseEntity<WealthTechStaff> updateStaff(@PathVariable("id") Integer staffId,
                                                       @Valid @RequestBody WealthTechStaff staffDetails) {
        WealthTechStaff wealthTechStaff = wealthTechStaffRepository.findById(staffId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid staff id : " + staffId));

        wealthTechStaff.setStaffName(staffDetails.getStaffName());
        wealthTechStaff.setStaffRole(staffDetails.getStaffRole());
        wealthTechStaff.setLenghtOfServiceYears(staffDetails.getLenghtOfServiceYears());

        return ResponseEntity.ok(this.wealthTechStaffRepository.save(wealthTechStaff));
    }

    /// DELECT STAFF record

    @DeleteMapping("home/{id}")
    public Map<String, Boolean> deleteStaff(@PathVariable("id") Integer staffId) {
        WealthTechStaff wealthTechStaff = wealthTechStaffRepository.findById(staffId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid staff id : " + staffId));
        this.wealthTechStaffRepository.delete(wealthTechStaff);

        Map<String, Boolean> response = new Hashtable<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }

    public void checkIfValueExists(String value) {
        List<String> values = Arrays.asList("Gbemileke", "Eugene", "Ifeoluwa", "Henry", "Tommy");

//        boolean isMatch = values.stream().anyMatch(val -> val.equals(value));
        boolean isMatch = false;
        for (String val : values) if (val.equals(value)) isMatch = true;

        if (!isMatch) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");

    }


}
