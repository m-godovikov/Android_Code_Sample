package bit.max.portfolio.presentation.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import bit.max.portfolio.R
import bit.max.portfolio.app.App
import bit.max.portfolio.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)
        val viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        binding.saveButton.setOnClickListener {
            val firstName = binding.firstnameEditText.text.toString()
            val lastName = binding.lastnameEditText.text.toString()

            viewModel.saveUserName(firstName = firstName, lastName = lastName)
        }


        binding.showButton.setOnClickListener {
            viewModel.fetchUserName()
        }

        setupUserNameIndicator(viewModel = viewModel)
        setupSaveUserNameResult(viewModel = viewModel)
    }

    private fun setupUserNameIndicator(viewModel: MainViewModel) {
        viewModel.fullUserName.observe(this) { fullUserName ->
            binding.resultTextView.text = fullUserName
        }
    }

    private fun setupSaveUserNameResult(viewModel: MainViewModel) {
        viewModel.savedSuccessful.observe(this) { savedSuccessful ->
            savedSuccessful ?: return@observe
            val message =
                getString(if (savedSuccessful) R.string.saved_succesful else R.string.save_error)
            showToast(message = message)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}