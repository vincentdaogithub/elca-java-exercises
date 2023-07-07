export interface ProjectNew {
    projectNumber: number;
    projectName: string;
    customer: string;
    groupId: number;
    members: number[];
    status: string;
    startDate: Date;
    endDate: Date;
}