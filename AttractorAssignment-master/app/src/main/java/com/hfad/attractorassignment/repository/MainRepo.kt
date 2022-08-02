package com.hfad.attractorassignment.repository

import com.hfad.attractorassignment.R
import com.hfad.attractorassignment.model.Company
import com.hfad.attractorassignment.model.User
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MainRepo {

    private var userData: User? = null

    init {
        userData = User(
            "Bakai", "Ismaiilov",
            R.drawable.me, 2,
            arrayListOf(
                Company("Attractor", "Android Developer"),
                Company("Google", "Android Developer")
            )
        )
    }

    fun getUserData(): UserDataView {
        val string = Json.encodeToString(userData)
        val data = Json.decodeFromString<User>(string)
        return userToUserViewData(data)
    }

    private fun userToUserViewData(user: User): UserDataView {
        return UserDataView(
            user.name,
            user.secondName,
            user.photo,
            encryptEducation(user.education),
            companyToCompanyViewData(user.company)
        )
    }

    private fun companyToCompanyViewData(company: List<Company>): List<CompanyViewData> {
        return company.map {
            CompanyViewData(
                it.name,
                it.position
            )
        }
    }

    private fun encryptEducation(educationCode: Int): String {
        return when (educationCode) {
            1 -> "High school"
            2 -> "Bachelor"
            3 -> "Master"
            4 -> "Doctoral"
            else -> "Uneducated"
        }
    }
}

data class UserDataView(
    var name: String? = "",
    var secondName: String? = "",
    var photo: Int? = null,
    var education: String? = "",
    var company: List<CompanyViewData>
)

data class CompanyViewData(
    val name: String? = "",
    val position: String? = ""
)