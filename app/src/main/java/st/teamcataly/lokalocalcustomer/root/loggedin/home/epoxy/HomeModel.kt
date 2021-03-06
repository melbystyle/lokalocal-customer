package st.teamcataly.lokalocalcustomer.root.loggedin.home.epoxy

import android.support.annotation.StringRes
import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import kotlinx.android.synthetic.main.home_rib.view.*
import st.teamcataly.lokalocalcustomer.R

/**
 * @author Melby Baldove
 * melbourne.baldove@owtoph.com
 */
@EpoxyModelClass(layout = R.layout.home_rib)
abstract class HomeModel : EpoxyModelWithHolder<HomeModel.Holder>() {
    @EpoxyAttribute
    @StringRes
    lateinit var name: String
    @EpoxyAttribute
    @StringRes
    lateinit var credits: String
    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    lateinit var historyListener: () -> Unit
    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    lateinit var qrListener: () -> Unit

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.view.apply {
            home_rib_name.text = "Welcome, $name!"
            home_rib_credits.text = "You have $credits credits"
            home_rib_history.setOnClickListener { historyListener() }
            home_rib_qr.setOnClickListener { qrListener() }
        }
    }

    class Holder : EpoxyHolder() {
        lateinit var view: View
        override fun bindView(itemView: View) {
            this.view = itemView
        }

    }
}