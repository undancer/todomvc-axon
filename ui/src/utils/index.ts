const FILTER_ALL = 'all';
const FILTER_ACTIVE = 'active';
const FILTER_COMPLETED = 'completed';

const applyFilter = (list: Todo[], filter: string) => {
    console.log(filter);
    switch (filter) {
        case FILTER_COMPLETED:
            return list.filter((item: Todo) => item.completed === true);
        case FILTER_ACTIVE:
            return list.filter((item: Todo) => item.completed === false);
        default:
            return list;
    }
};

export {applyFilter, FILTER_ALL, FILTER_ACTIVE, FILTER_COMPLETED};