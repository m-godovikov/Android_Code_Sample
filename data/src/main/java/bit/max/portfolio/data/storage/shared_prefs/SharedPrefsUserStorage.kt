package bit.max.portfolio.data.storage.shared_prefs

import android.content.Context
import bit.max.portfolio.data.storage.UserStorage
import bit.max.portfolio.data.storage.models.User

private const val KEY_FIRST_NAME = "first_name"
private const val KEY_LAST_NAME = "last_name"
private const val DEFAULT_FIRST_NAME = "FIRST_NAME_NOT_DEFINED"
private const val DEFAULT_LAST_NAME = "LAST_NAME_NOT_DEFINED"

class SharedPrefsUserStorage(context: Context) : UserStorage {

    private val sharedPreferences = context.getSharedPreferences("shp", Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences
            .edit()
            .putString(KEY_FIRST_NAME, user.firstName)
            .putString(KEY_LAST_NAME, user.lastName)
            .apply()
        return true
    }

    override fun load(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, null) ?: DEFAULT_FIRST_NAME
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, null) ?: DEFAULT_LAST_NAME
        return User(firstName = firstName, lastName = lastName)
    }
}