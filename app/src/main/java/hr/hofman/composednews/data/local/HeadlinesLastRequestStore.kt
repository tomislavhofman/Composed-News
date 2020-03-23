package hr.hofman.composednews.data.local

import hr.hofman.composednews.data.local.Request.HEADLINES
import hr.hofman.composednews.data.local.dao.LastRequestDao
import javax.inject.Inject

class HeadlinesLastRequestStore @Inject constructor(
    dao: LastRequestDao
) : GroupLastRequestStore(HEADLINES, dao)