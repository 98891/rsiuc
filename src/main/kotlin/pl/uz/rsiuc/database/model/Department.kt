@file:Suppress("JpaDataSourceORMInspection")

package pl.uz.rsiuc.database.model

import jakarta.persistence.*

@Entity
@Table(name = "department")
data class Department(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,

    val name: String = "",
    val address: String = "",
    val phone: String = "",
    val mail: String = "",
    val www: String = "",
    val description: String = "",

    @OneToMany
    var appUsers: List<AppUser> = emptyList(),

    @OneToOne
    val manager: AppUser? = null
)
