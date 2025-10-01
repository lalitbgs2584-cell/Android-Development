import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {

    private val _count = MutableLiveData(0)  // backing property
    val count: LiveData<Int> get() = _count // read-only LiveData

    fun increment() {
        _count.value = (_count.value ?: 0) + 1
    }

    fun decrement() {
        _count.value = (_count.value ?: 0) - 1
    }
}
