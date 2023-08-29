package study.yeoboya.gallery

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import study.yeoboya.gallery.extension.showToast
import study.yeoboya.gallery.util.Util

class MainActivity : AppCompatActivity() {

    private val imageView: ImageView by lazy { findViewById(R.id.image) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkPermission()
    }

    /**
     * 외부 저장소 접근 권한 확인 및 요청
     * */
    private fun checkPermission() {
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                setImageView()
            } else {
                showToast(R.string.denied_permission_read_external_storage_message)
            }
        }.apply { launch(android.Manifest.permission.READ_EXTERNAL_STORAGE) }
    }

    /**
     * ImageView에 이미지 그리기
     * */
    private fun setImageView() {
        runCatching {
            Util.getImages(this).last()
        }.onSuccess { uri ->
            Glide.with(this)
                .load(uri)
                .into(imageView)
        }.onFailure {
            showToast(R.string.not_found_image_message)
        }
    }
}