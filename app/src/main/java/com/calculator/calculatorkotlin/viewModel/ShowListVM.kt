package com.calculator.calculatorkotlin.viewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.calculator.calculatorkotlin.model.CalculateModel
import com.calculator.calculatorkotlin.repository.CalculatorRepository
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import java.io.File
import java.io.FileOutputStream
import java.text.DateFormat
import java.util.*


class ShowListVM(private val calculatorRepository: CalculatorRepository,private val application: Application) : ViewModelProvider.Factory {
    private lateinit var  filePath: File
    private var calculatorList = mutableListOf<CalculateModel>()

    fun onSaveBtnClickListener() {

        if (calculatorList.size==0){
            Toast.makeText(application,"nothing to save !!",Toast.LENGTH_LONG).show()
            return
        }

        filePath= File(application.getExternalFilesDir("ExcelFile"), "Calculator__${randomNum(5000,1000)}.xls")
        val hssfWorkbook = HSSFWorkbook()
        val hssfSheet = hssfWorkbook.createSheet("Custom Sheet")

        val hssfRowMain = hssfSheet.createRow(0)
        hssfRowMain.createCell(0).setCellValue("result")
        hssfRowMain.createCell(1).setCellValue("point1-x")
        hssfRowMain.createCell(2).setCellValue("point1-y")
        hssfRowMain.createCell(3).setCellValue("point2-x")
        hssfRowMain.createCell(4).setCellValue("point2-y")

        for (i in 0 until calculatorList.size) {
            val hssfRow = hssfSheet.createRow(i+1)
            hssfRow.createCell(0).setCellValue(calculatorList[i].result.toString())
            hssfRow.createCell(1)
                .setCellValue(calculatorList[i].listOfDirectionModel[0].x.toString())
            hssfRow.createCell(2)
                .setCellValue(calculatorList[i].listOfDirectionModel[0].y.toString())
            hssfRow.createCell(3)
                .setCellValue(calculatorList[i].listOfDirectionModel[1].x.toString())
            hssfRow.createCell(4)
                .setCellValue(calculatorList[i].listOfDirectionModel[1].y.toString())
        }

        try {
            if (!filePath.exists()) {
                filePath.createNewFile()
            }
            val fileOutputStream = FileOutputStream(filePath)
            hssfWorkbook.write(fileOutputStream)
            if (fileOutputStream != null) {
                fileOutputStream.flush()
                fileOutputStream.close()
            }

            calculatorRepository.deleteAll()

            Toast.makeText(application,"Save all successfully",Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun setCalculateList(calculatorList: List<CalculateModel>) {
        this.calculatorList = calculatorList as MutableList<CalculateModel>
    }

    fun randomNum(max:Int,min:Int):Int{
        return (Math.random() * (max-min+1)+min).toInt()
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShowListVM(calculatorRepository, application) as T
    }
}