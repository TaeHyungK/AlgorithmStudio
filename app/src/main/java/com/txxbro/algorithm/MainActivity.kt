package com.txxbro.algorithm

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.txxbro.algorithm.ui.theme.AlgorithmTheme
import kotlin.collections.forEach
import kotlin.math.min

class MainActivity : ComponentActivity() {
    private val TAG = "taehyung_test"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlgorithmTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val lazyListState = rememberLazyListState()
                    LazyColumn(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        state = lazyListState
                    ) {
                        item {
                            ResultText(
                                text = "merge",
                                onClick = {
//                            val nums1 = arrayOf(1,2,3,0,0,0)
//                            val m = 3
//                            val nums2 = arrayOf(2,5,6)
//                            val n = 3
                                    val nums1 = arrayOf(1)
                                    val m = 1
                                    val nums2 = emptyArray<Int>()
                                    val n = 0
                                    merge(
                                        nums1 = nums1.toIntArray(),
                                        m = m,
                                        nums2 = nums2.toIntArray(),
                                        n = n
                                    )
                                }
                            )
                        }

                        item {
                            ResultText(
                                text = "removeElement",
                                onClick = {
//                                    val nums = arrayOf(3,2,2,3)
//                                    val value = 3
//                                    val nums = arrayOf(0,1,2,2,3,0,4,2)
//                                    val value = 2
                                    val nums = emptyArray<Int>()
                                    val value = 0
                                    removeElement(
                                        nums = nums.toIntArray(),
                                        value = value
                                    )
                                }
                            )
                        }

                        item {
                            ResultText(
                                text = "removeDuplicates",
                                onClick = {
                                    val nums = arrayOf(0,0,1,1,1,2,2,3,3,4)
                                    removeDuplicates(
                                        nums = nums.toIntArray()
                                    )
                                    removeDuplicatesBest(
                                        nums = nums.toIntArray()
                                    )
                                }
                            )
                        }

                        item {
                            ResultText(
                                text = "removeDuplicatesMedium",
                                onClick = {
                                    val nums = arrayOf(1,1,1,2,2,3)
                                    removeDuplicatesMedium(
                                        nums = nums.toIntArray()
                                    )
                                }
                            )
                        }

                        item {
                            ResultText(
                                text = "majorityElement",
                                onClick = {
                                    val nums = arrayOf(2,2,1,1,1,2,2)
                                    majorityElement(
                                        nums = nums.toIntArray()
                                    )
                                    majorityElementFollowUp(
                                        nums = nums.toIntArray()
                                    )
                                }
                            )
                        }

                        item {
                            ResultText(
                                text = "rotate",
                                onClick = {
                                    val nums = arrayOf(1,2,3,4,5,6,7)
                                    val k = 3
//                                    val nums = arrayOf(-1, -100, 3, 99)
//                                    val k = 2
//                                    val nums = arrayOf(1,7)
//                                    val k = 7
                                    rotateFast(
                                        nums = nums.toIntArray(),
                                        k
                                    )
                                }
                            )
                        }

                        item {
                            ResultText(
                                text = "maxProfit",
                                onClick = {
                                    val prices = arrayOf(7,1,5,3,6,4)
//                                    val prices = arrayOf(7,6,4,3,1)
//                                    val prices = arrayOf(2,4,1)
                                    maxProfit(
                                        prices = prices.toIntArray(),
                                    )
                                }
                            )
                        }

                        item {
                            ResultText(
                                text = "maxProfit Medium",
                                onClick = {
//                                    val prices = arrayOf(7,1,5,3,6,4)
//                                    val prices = arrayOf(7,6,4,3,1)
//                                    val prices = arrayOf(2,4,1)
                                    val prices = arrayOf(1,2,3,4,5)
                                    maxProfitMedium(
                                        prices = prices.toIntArray(),
                                    )
                                }
                            )
                        }

                        item {
                            ResultText(
                                text = "canJump",
                                onClick = {
//                                    val nums = arrayOf(2,3,1,1,4)
                                    val nums = arrayOf(3,2,1,0,4)
                                    canJump(
                                        nums = nums.toIntArray(),
                                    )
                                }
                            )
                        }

                        item {
                            ResultText(
                                text = "jump",
                                onClick = {
                                    val nums = arrayOf(2,3,1,1,4)
//                                    val nums = arrayOf(3,2,1,0,4)
                                    jump(
                                        nums = nums.toIntArray(),
                                    )
                                }
                            )
                        }

                        item {
                            ResultText(
                                text = "hIndex",
                                onClick = {
//                                    val citations = intArrayOf(3,0,6,1,5)
                                    val citations = intArrayOf(1,3,1)
                                    hIndex(
                                        citations = citations
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }

    private fun merge(
        nums1: IntArray,
        m: Int,
        nums2: IntArray,
        n: Int
    ) {
        val result = IntArray(size = m + n)

        var i = 0
        var num1Pointer = 0
        var num2Pointer = 0
        while(i < result.size) {
            val num1 = if (num1Pointer < m) {
                nums1[num1Pointer]
            } else {
                Int.MAX_VALUE
            }
            val num2 = if (num2Pointer < n) {
                nums2[num2Pointer]
            } else {
                Int.MAX_VALUE
            }

            if (num1 <= num2) {
                result[i] = num1
                num1Pointer++
            } else {
                result[i] = num2
                num2Pointer++
            }
            i++
        }

        for (i in result.indices) {
            nums1[i] = result[i]
            Log.d(TAG, "merge: ${nums1[i]}")
        }
    }

    private fun removeElement(nums: IntArray, value: Int): Int {
        if (nums.isEmpty()) {
            return 0
        }

        fun IntArray.findLastPosition(predicate: (Int) -> Boolean): Int? {
            for (i in this.indices.reversed()) {
                val element = this[i]
                if (predicate(element)) {
                    return i
                }
            }
            return null
        }
        var start = 0
        var end = nums.findLastPosition { it != value } ?: 0

        while (start <= end) {
            if (nums[start] == value) {
                val temp = nums[start]
                nums[start] = nums[end]
                nums[end] = temp
                start++
                end = nums.findLastPosition { it != value } ?: (end - 1)
            } else {
                start++
            }
        }

        var listText = ""
        nums.forEach {
            listText += "$it "
        }
        Log.d(TAG, "removeElement: listText: $listText | result: ${nums.findLastPosition { it != value } }}")

        return nums.findLastPosition { it != value }?.plus(1) ?: 0
    }

    private fun removeDuplicates(nums: IntArray): Int {
        val result = mutableListOf<Int>()
        var index = 0
        nums.forEach { num ->
            if (!result.contains(num)) {
                result.add(num)
                nums[index] = num
                index++
            }
        }

        var listText = ""
        nums.forEach {
            listText += "$it "
        }
        Log.d(TAG, "removeDuplicates: listText: $listText | return: ${result.size}")

        return result.size
    }

    private fun removeDuplicatesBest(nums: IntArray): Int {
        var index = 1
        for (i in 1..<nums.size) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i]
                index++
            }
        }

        var listText = ""
        nums.forEach {
            listText += "$it "
        }
        Log.d(TAG, "removeDuplicatesBest: listText: $listText | return: $index")
        return index
    }

    private fun removeDuplicatesMedium(nums: IntArray): Int {
        if (nums.size <= 2) {
            return nums.size
        }

        var p = 2
        for (i in 2..<nums.size) {
            if (nums[i] != nums[p - 2]) {
                nums[p] = nums[i]
                p++
            }
        }

        var listText = ""
        nums.forEach {
            listText += "$it "
        }
        Log.d(TAG, "removeDuplicatesMedium: listText: $listText | return: $p")
        return p
    }

    private fun majorityElement(nums: IntArray): Int {
        val counterMap = mutableMapOf<Int, Int>()

        nums.forEach { num ->
            val current = counterMap[num]
            counterMap[num] = current?.plus(1) ?: 1
        }

        var listText = ""
        counterMap.forEach {
            listText += "${it.key}: ${it.value} | "
        }
        Log.d(TAG, "majorityElement: listText: $listText | return: ${counterMap.maxBy { it.value }.key}")
        return counterMap.maxBy { it.value }.key
    }

    private fun majorityElementFollowUp(nums: IntArray): Int {
        var max = 0
        var count = 0

        nums.forEach { num ->
            if (count == 0) {
                max = num
            }
            if (max == num) {
                count++
            } else {
                count--
            }
        }

        Log.d(TAG, "majorityElementFollowUp: return: ${max}")
        return max
    }

    private fun rotate(nums: IntArray, k: Int) {
        if (nums.size <= 1) {
            return
        }

        fun rightShift(nums: IntArray) {
            val last = nums.last()
            var captured = nums[0]

            nums[0] = last
            for (i in 1..nums.size - 1) {
                val target = captured
                captured = nums[i]
                nums[i] = target
            }
        }

        for (i in 0..k - 1) {
            rightShift(nums)
        }

        var listText = ""
        nums.forEach {
            listText += "$it | "
        }
        Log.d(TAG, "rotate: result: $listText")
    }

    private fun rotateFast(nums: IntArray, k: Int) {
        val size = nums.size
        val steps = k % nums.size

        fun reverse(start: Int, end: Int) {
            var left = start
            var right = end
            while (left < right) {
                var temp = nums[left]
                nums[left] = nums[right]
                nums[right] = temp
                left++
                right--
            }
        }

        reverse(0, size - 1)
        reverse(0, steps - 1)
        reverse(steps, size - 1)

        var listText = ""
        nums.forEach {
            listText += "$it | "
        }
        Log.d(TAG, "rotateFast: result: $listText")
    }

    private fun maxProfitFailure(prices: IntArray): Int {
        // Time Limit Exceeded code !
        if (prices.isEmpty()) {
            return 0
        }

        var maxProfit = 0
        for (i in prices.indices) {
            val cur = prices[i]
            var maxValueAfterCur = cur
            for (j in i..prices.size - 1) {
                val temp = prices[j]
                if (maxValueAfterCur < temp) {
                    maxValueAfterCur = temp
                }
            }

            val tempGap = maxValueAfterCur - cur
            if (maxProfit < tempGap) {
                maxProfit = tempGap
            }
        }

        Log.d(TAG, "maxProfit: result: $maxProfit")
        return maxProfit
    }

    private fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()){
            return 0
        }

        var buy = prices[0]
        var maxProfit = 0

        for (i in 1..prices.size - 1) {
            val price = prices[i]
            if (price < buy) {
                buy = price
            } else {
                val gap = price - buy
                if (maxProfit < gap) {
                    maxProfit = gap
                }
            }
        }

        Log.d(TAG, "maxProfit: result: $maxProfit")
        return maxProfit
    }

    fun maxProfitMedium(prices: IntArray): Int {
        if (prices.isEmpty()) {
            return 0
        }

        var sum = 0
        for (i in 1..prices.size - 1) {
            val prevPrice = prices[i - 1]
            val prices = prices[i]

            sum += maxOf(0, prices - prevPrice)
        }
        Log.d(TAG, "maxProfitMedium: result: $sum")
        return sum
    }

    private fun canJump(nums: IntArray): Boolean {
        var targetIndex = nums.lastIndex
        for(i in nums.lastIndex - 1 downTo 0) {
            val num = nums[i]
            if (i + num >= targetIndex) {
                targetIndex = i
            }
        }

        Log.d(TAG, "canJump: result: ${targetIndex == 0}")
        return targetIndex == 0
    }

    private fun jump(nums: IntArray): Int {
        val jumpIndexes = nums.mapIndexed { index, value ->
            index + value
        }

        var targetIndex = jumpIndexes.lastIndex
        var result = 0
        while (targetIndex > 0) {
            val prev = (0 until targetIndex).firstOrNull {
                jumpIndexes[it] >= targetIndex
            } ?: return -1 // 도달 불가한 경우
            targetIndex = prev
            result++
        }

        var listText = ""
        jumpIndexes.forEach {
            listText += "$it "
        }
        Log.d(TAG, "jump: listText: $listText | result: $result")
        return result
    }

    private fun hIndex(citations: IntArray): Int {
        /**
         * sort() 로 하고 if문을 citiations[i] <= ciations.size - i 로 해도 될 것 같아보이지만,
         * 실제로는 같은 값이 있는 경우(1,3,1) -> 1,1,3 으로 두번째 1을 한번더 돌면서 result가 맞지 않는 케이스가 생긴다.
         * 해서 내림차순으로 정리해서 중복된 값이 체크되지 않도록 해야 함
         */
        citations.sortDescending()
        var result = 0
        for (i in citations.indices) {
            if (citations[i] >= i + 1) {
                result++
            } else {
                break
            }
        }

        var listText = ""
        citations.forEach {
            listText += "$it "
        }
        Log.d(TAG, "jump: listText: $listText | result: $result")
        return result
    }
}

@Composable
fun ResultText(
    text: String,
    onClick: () -> Unit
) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onClick.invoke()
            }
    )
}
