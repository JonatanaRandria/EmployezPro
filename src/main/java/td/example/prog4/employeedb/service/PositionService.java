package td.example.prog4.employeedb.service;

import td.example.prog4.employeedb.repository.PositionRepository;
import td.example.prog4.employeedb.repository.entity.Position;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PositionService {
    private PositionRepository repository;

    public List<Position> getAll(){
        return repository.findAll();
    }
    public Position saveOne(Position position){
        return repository.save(position);
    }
}
