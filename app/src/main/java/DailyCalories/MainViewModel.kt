package DailyCalories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fitfusion.Food.Food

class MainViewModel : ViewModel() {
    private val _foodList = MutableLiveData<List<Food>>(emptyList())
    val foodList: LiveData<List<Food>> = _foodList

    fun addFood(food: Food) {
        _foodList.value = _foodList.value?.toMutableList()?.apply { add(food) }
    }

    fun clearFoodList() {
        _foodList.value = emptyList()
    }
}
