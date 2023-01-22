package pl.uz.rsiuc.database.repository

import org.springframework.data.repository.CrudRepository
import pl.uz.rsiuc.database.model.AppUser
import pl.uz.rsiuc.database.model.Department

interface DepartmentRepository : CrudRepository<Department, Int> {
    fun findDepartmentByManagerFirstNameAndManagerLastName(firstName: String, lastName: String): Department
}