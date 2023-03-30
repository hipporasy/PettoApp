package codes.hipporasy.pettoapp.android.presentation.splash

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import codes.hipporasy.pettoapp.android.R
import codes.hipporasy.pettoapp.android.ui.theme.LightGray
import codes.hipporasy.pettoapp.android.ui.theme.PrimaryVariant

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@OptIn(ExperimentalFoundationApi::class)
@RootNavGraph(start = true)
@Destination
@Composable
fun SplashScreen(
    navigator: DestinationsNavigator
) {

    var selectedIndex by remember { mutableStateOf(0) }
    val pagerState = rememberPagerState()
    val items = OnBoardingType.values()

    LaunchedEffect(pagerState) {
        // Collect from the a snapshotFlow reading the currentPage
        snapshotFlow { pagerState.currentPage }.collect { page ->
            selectedIndex = page
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryVariant),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(52.dp))
        HorizontalPager(
            pageCount = items.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) {
            OnBoardingContent(type = items[it])
        }
        Spacer(modifier = Modifier.height(24.dp))
        DotsIndicator(
            totalDots = items.size,
            selectedIndex = selectedIndex,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(0.dp, 35.dp, 35.dp, 0.dp),
                elevation = null,
                modifier = Modifier
                    .height(80.dp)
                    .width(115.dp)
            ) {
                Text(
                    text = "Skip",
                    color = MaterialTheme.colors.onSurface
                )
            }
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(35.dp, 0.dp, 0.dp, 35.dp),
                elevation = null,
                modifier = Modifier
                    .height(80.dp)
                    .width(115.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onSurface)
            ) {
                Text("Get Started", color = MaterialTheme.colors.primary)
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
    }
}


@Composable
fun OnBoardingContent(type: OnBoardingType) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = type.imageRes),
            contentDescription = stringResource(id = R.string.image),
            contentScale = ContentScale.Fit,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                stringResource(id = type.titleRes),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.onSurface
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                stringResource(id = type.descriptionRes),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}

@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int,
) {

    LazyRow(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()

    ) {

        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .width(24.dp)
                        .height(8.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.primary)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .border(1.dp, color = LightGray, shape = CircleShape)
                        .clip(CircleShape)
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

enum class OnBoardingType {
    ONE {
        override val titleRes: Int
            get() = R.string.splash_1
        override val descriptionRes: Int
            get() = R.string.splash_1_description
        override val imageRes: Int
            get() = R.drawable.splash_3
    },
    TWO {
        override val titleRes: Int
            get() = R.string.splash_2
        override val descriptionRes: Int
            get() = R.string.splash_2_description
        override val imageRes: Int
            get() = R.drawable.splash_2
    },
    THREE {
        override val titleRes: Int
            get() = R.string.splash_3
        override val descriptionRes: Int
            get() = R.string.splash_3_description
        override val imageRes: Int
            get() = R.drawable.splash_1
    };

    abstract val titleRes: Int
    abstract val imageRes: Int
    abstract val descriptionRes: Int

}