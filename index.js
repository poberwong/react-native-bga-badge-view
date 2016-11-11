import { PropTypes } from 'react'
import { requireNativeComponent, View } from 'react-native'

module.exports = requireNativeComponent('AndroidBGABadgeView', {
	name: 'BGABadgeView',
	propTypes: {
		circlePointBadge: PropTypes.bool,
		textBadge: PropTypes.string,
		badgeTextColor: PropTypes.string,
		badgeBgColor: PropTypes.string,
		drawableBadge: PropTypes.string,
		dragable: PropTypes.bool,
		badgeTextSizeSp: PropTypes.number,
		badgePaddingDp: PropTypes.number,
		badgeBorderWidthDp: PropTypes.number,
		badgeBorderColor: PropTypes.string,
		onDismiss: PropTypes.func,
		...View.propTypes
	}
})