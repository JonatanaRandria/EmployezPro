package td.example.prog4.employeedb.service;

import td.example.prog4.employeedb.repository.PhoneRepository;
import td.example.prog4.employeedb.repository.entity.Phone;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PhoneService {
    private PhoneRepository repository;

    public List<Phone> getAll(){
        return repository.findAll();
    }

    public Phone saveOne(Phone position){
        return repository.save(position);
    }
}
