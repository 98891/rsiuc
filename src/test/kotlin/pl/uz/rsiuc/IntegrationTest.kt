package pl.uz.rsiuc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import pl.uz.rsiuc.database.model.AppUser
import pl.uz.rsiuc.database.model.Department
import pl.uz.rsiuc.database.repository.AppUserRepository
import pl.uz.rsiuc.database.repository.DepartmentRepository
import java.time.LocalDateTime

@DataJpaTest
class IntegrationTest {

    @Autowired
    private lateinit var userRepository: AppUserRepository

    @Autowired
    private lateinit var departmentRepository: DepartmentRepository

    private lateinit var departments: List<Department>
    private lateinit var managers: List<AppUser>
    private lateinit var users: List<AppUser>

    @BeforeEach
    fun setup() {
        departments = listOf(
            Department(name = "Department_1"),
            Department(name = "Department_2")
        )
        managers = listOf(
            AppUser(
                userName = "Manager_1",
                password = "",
                firstName = "M1",
                lastName = "M1",
                description = "",
                payment = 1000f,
                bonus = 1000f,
                dateOfPayment = LocalDateTime.of(2022, 10,10, 10, 10, 10),
                department = departments[0]
            ),
            AppUser(
                userName = "Manager_2",
                password = "",
                firstName = "M2",
                lastName = "M2",
                description = "",
                payment = 1000f,
                bonus = 1000f,
                dateOfPayment = LocalDateTime.of(2022, 10,10, 10, 10, 10),
                department = departments[1]
            )
        )
        users = listOf(
            AppUser(
                userName = "user_1",
                payment = 100f,
                department = departments[0]
            ),
            AppUser(
                userName = "user_2",
                payment = 100f,
                department = departments[0]
            ),
            AppUser(
                userName = "user_3",
                payment = 100f,
                dateOfPayment = LocalDateTime.of(2022, 4,4, 15, 1, 1),
                department = departments[0]
            ),
            AppUser(
                userName = "user_4",
                payment = 100f,
                department = departments[1]
            ),
            AppUser(
                userName = "user_5",
                payment = 100f,
                department = departments[1]
            )
        )

        departmentRepository.saveAll(departments)
        userRepository.saveAll(managers)
        userRepository.saveAll(users)
        departments = listOf(
            departments[0].copy(manager = managers[0]),
            departments[1].copy(manager = managers[1])
        )
        departmentRepository.saveAll(departments)
    }

    @Test
    fun `When called findAllDepartments, Then zwraca wszystkie departamenty systemu`() {
        val departments = departmentRepository.findAll()

        assertThat(departments.count()).isEqualTo(2)
    }

    @Test
    fun `when called save - then correct number of app userss`() {
        val users = userRepository.findAppUsersByPaymentIsGreaterThan(100f)

        assertThat(users.count()).isEqualTo(2)
    }
}