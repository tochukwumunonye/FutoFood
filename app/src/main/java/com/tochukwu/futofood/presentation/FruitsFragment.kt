package com.tochukwu.futofood.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tochukwu.futofood.R
import com.tochukwu.futofood.databinding.FruitsFragmentBinding
import com.tochukwu.futofood.util.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FruitsFragment  : Fragment(R.layout.fruits_fragment) {

    private val viewModel: FruitListViewModel by viewModels()
    private var _binding: FruitsFragmentBinding? =  null

    private val binding get() = _binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FruitsFragmentBinding.bind(view)

        viewModel.getFruits()

        val fruitAdapter = FruitsAdapter()

        binding?.apply{
            rvSearchResults.apply{
                adapter = fruitAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
                itemAnimator?.changeDuration = 0
            }

            viewModel.fruitsChannel.observe(viewLifecycleOwner, Observer{
                it?.getContentIfNotHandled()?.let{res ->
                    when(res.status){
                        Status.SUCCESS -> {
                            val url = res.data
                            searchProgressBar.isInvisible = true
                            fruitAdapter.submitList(url)
                        }
                        Status.LOADING -> {
                            searchProgressBar.isVisible = true
                        }
                    }
                }

            })
        }

    }


}

/**
 *
 *
 *


viewModel.coinz.observe(viewLifecycleOwner, Observer {
it?.getContentIfNotHandled()?.let{result->
when(result.status){
Status.SUCCESS ->{
val  url = result.data
homeAdapter.submitList(url)
}
}
}
})

}
}
}

 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *

@AndroidEntryPoint
class CharacterFragment(
var disneyAdapter: DisneyAdapter,
var viewModel: CharacterViewModel? = null
) :Fragment(R.layout.fragment_home){

// private val viewModel: CharacterViewModel by viewModels()



private var _binding: FragmentHomeBinding? = null
private val binding get() = _binding!!


override fun onCreateView(
inflater: LayoutInflater,
container: ViewGroup?,
savedInstanceState: Bundle?
): View? {
_binding = FragmentHomeBinding.inflate(inflater, container, false)


return _binding?.root
}

override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
super.onViewCreated(view, savedInstanceState)

viewModel =
viewModel ?: ViewModelProvider(requireActivity()).get(CharacterViewModel::class.java)

viewModel?.getDisney()
setUpObserver()
setUpRecyclerView()
}
private fun setUpObserver(){
viewModel?.disneyChannel?.observe(viewLifecycleOwner, {
it?.getContentIfNotHandled()?.let { res->
when(res.status){
Status.SUCCESS ->{
val data = res.data
disneyAdapter.submitList(data)
}
Status.LOADING ->{
val data = res.data
disneyAdapter.submitList(data)

}

Status.ERROR ->{
val data = res.data
disneyAdapter.submitList(data)
Toast.makeText(activity, res.message, Toast.LENGTH_SHORT).show()
}
}


}
})

}
private fun setUpRecyclerView() {
// disneyAdapter = DisneyAdapter()

binding.recycler.apply{
adapter = disneyAdapter
layoutManager = LinearLayoutManager(requireContext())
itemAnimator = null
}
}

}
**/