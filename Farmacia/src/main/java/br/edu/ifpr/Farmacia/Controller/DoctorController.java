package br.edu.ifpr.Farmacia.Controller;

import br.edu.ifpr.Farmacia.Repository.DoctorRepository;
import br.edu.ifpr.Farmacia.Model.Doctor;
 import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController// This means that this class is a Controller
@RequestMapping(path="/doctor")
public class DoctorController {
   @Autowired 
  private DoctorRepository doctorRepository;

  @PostMapping(path="/add") // Map ONLY POST Requests
  @ResponseBody
  public String createDoctor(@RequestBody Doctor doctor) {
    doctorRepository.save(doctor);
    return "ok";
  }
  @GetMapping(path="/all")
  public @ResponseBody Iterable<Doctor> getAllUsers() {
    // This returns a JSON or XML with the users
    return doctorRepository.findAll();
  }
}