package com.example.kotlinbugtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.fastjson.JSON
import com.example.kotlinbugtest.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    private var testJson = """
        {
            "c_name": "养成早睡早起的三个关键步骤",
            "count": 20,
            "teacher": "张三",
            "is_like": 1,
            "is_collect": true
        }
    """

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.txtJson.text ="字符串："+ testJson

        //使用fastjson解析
        mBinding.btnExec.setOnClickListener {
            val classBean = JSON.parseObject(testJson, ClassBean::class.java)
            mBinding.txtResult.text = "对象："+classBean.toString()
        }

        //对象转换成json字符串
        val classBean1 = ClassBean("课程名称一", 10, true, 1, "小明")
        mBinding.txtBean.text = "bean对象："+classBean1.toString()
        mBinding.btnToJSON.setOnClickListener {
            mBinding.txtJsonResult.text ="Json字符串："+ JSON.toJSONString(classBean1)
        }

    }
}