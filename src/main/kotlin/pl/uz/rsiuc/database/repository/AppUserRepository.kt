package pl.uz.rsiuc.database.repository

import org.springframework.data.repository.CrudRepository
import pl.uz.rsiuc.database.model.AppUser

interface AppUserRepository : CrudRepository<AppUser, Int> {
    fun findAppUsersByPaymentIsGreaterThan(payment: Float): List<AppUser>
    fun findAppUsersByDepartmentName(departmentName: String): List<AppUser>
    fun findAppUsersByFirstNameAndLastNameAndDepartmentName(
        firstName: String,
        lastName: String,
        departmentName: String
    ): List<AppUser>
}