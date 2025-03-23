package com.example.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            // FragmentManager를 통해서 FragmentTransaction 획득하기
            val fragmentTransaction: FragmentTransaction =
                supportFragmentManager.beginTransaction()
            // add를 통해 container에 Fragment 추가
            fragmentTransaction.add(R.id.fragment_constraint, Constraint())
            fragmentTransaction.setReorderingAllowed(true)
            // commit을 통해 transaction 등록
            fragmentTransaction.commit()


            // FragmentKTX의 기능을 사용하여 위의 코드를 깔끔하게 변경
            // commit 함수 내부에 FragmentTransaction을 수신객체로 받는
            // 함수 타입이 있어서 아래와 같이 작성 가능
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_constraint, Constraint())
            }
        }
    }
}