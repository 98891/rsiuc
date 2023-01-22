package pl.uz.rsiuc.database.service

import org.springframework.stereotype.Service
import pl.uz.rsiuc.database.repository.AppUserRepository
import pl.uz.rsiuc.database.repository.DepartmentRepository

@Service
class Service(
    private val appUserRepository: AppUserRepository,
    private val departmentRepository: DepartmentRepository,
) {
    fun test() {
        appUserRepository.findAll()
        appUserRepository.findAppUsersByPaymentIsGreaterThan(100.0f)
        appUserRepository.findAppUsersByDepartmentName("test")
        appUserRepository.findAppUsersByFirstNameAndLastNameAndDepartmentName("test", "test", "test")

        departmentRepository.findDepartmentByManagerFirstNameAndManagerLastName("", "")
    }
}