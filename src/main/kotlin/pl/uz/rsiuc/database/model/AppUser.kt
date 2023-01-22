@file:Suppress("JpaDataSourceORMInspection")

package pl.uz.rsiuc.database.model

import jakarta.persistence.*
import java.time.LocalDateTime
import java.time.ZoneOffset

@Entity
@Table(name = "app_user")
data class AppUser(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,
    val userName: String = "",
    val password: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val description: String = "",
    val payment: Float = 0f,
    val bonus: Float = 0f,
    val dateOfPayment: LocalDateTime = LocalDateTime.ofEpochSecond(0L, 0, ZoneOffset.UTC),

    @ManyToOne
    val department: Department? = null
)
