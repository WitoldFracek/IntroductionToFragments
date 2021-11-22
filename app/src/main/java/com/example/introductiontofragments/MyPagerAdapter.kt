package layout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.introductiontofragments.Fragment11
import com.example.introductiontofragments.Fragment12

class MyPagerAdapter(fm: FragmentManager, behaviour: Int): FragmentPagerAdapter(fm, behaviour) {

    private val pages = 2

    override fun getItem(position: Int): Fragment {
        val ret: Fragment = when(position) {
            0 -> Fragment11.newInstance("frag11", "Page # 1")
            else -> Fragment12.newInstance("frag12", "Page # 1")
        }
        return ret
    }

    override fun getCount(): Int {
        return pages
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return super.getPageTitle(position)
    }
}