package dk.easj.anbo.safeargsexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dk.easj.anbo.safeargsexample.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            val name = binding.edittextName.text.toString().trim()
            val ageStr = binding.edittextAge.text.toString().trim()
            if (name.isEmpty()) {
                binding.edittextName.error = "No name"
                return@setOnClickListener
            }
            if (ageStr.isEmpty()) {
                binding.edittextAge.error = "No age"
                return@setOnClickListener
            }
            val age = ageStr.toInt()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(name, age, Student("Anders", 25))
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}